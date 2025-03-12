import fetch from 'node-fetch'

export class LinksChecker {

    private regex: RegExp = /(src|href)\s*=\s*["']([^"']*)["']/g

    async checkLinksOfPage(url: string) {

        const html: string = await this.getHtmlFromURL(url)
        
        let urls: string[] = this.scrapePageForSubLinks(html)
        urls = this.absolutizeURLs(urls, url)

        const statusCodes = await this.testURLs(urls)

        console.log(statusCodes)
    }

    async getHtmlFromURL(url): Promise<string> {
        return fetch(url, {})
            .then(res => res.text())
            .catch(err => {
                console.log(err)
            })
    }

    scrapePageForSubLinks(html: string): string[] {

        const matches: RegExpMatchArray = html.match(this.regex)
        const urls: string[] = matches.map(match => 
            match.split(match.includes('href') ? 'href=' : 'src=')[1].slice(1, -1)
        )
        return urls
    }

    absolutizeURLs(urls: string[], baseUrl: string): string[] {

        return urls.map(url => {

            if (url.includes('://')) return url
            if (url.startsWith('../')) return baseUrl.split('/').slice(0, -2).join('/') + '/' + url.slice(3)
            if (url.startsWith('./')) return baseUrl + '/' + url.slice(2)

            return (url.startsWith('/') ? `${baseUrl.slice(1)}` : `${baseUrl}`) + '/' + url
        }) 
    }

    async testURLs(urls: string[]): Promise<any[]> {

        const statusCodes: any[] = []

        for (const url of urls) {
            try {
                const res = await fetch(url, {})
                statusCodes.push(res.status)
            } catch (err) {
                statusCodes.push(err.code)
            }
        }

        return statusCodes
    }
}