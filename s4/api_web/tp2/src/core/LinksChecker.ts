import { rawFetch, fetchHtml, scrapePageForSubLinks } from '../utils'

export class LinksChecker {

    async checkLinksOfPage(baseUrl: string): Promise<String[]> {

        const html = await fetchHtml(baseUrl)
        if (!html) return null

        const relativeUrls = scrapePageForSubLinks(html),
              urls = this.absolutizeURLs(relativeUrls, baseUrl)

        const contentTypes = await this.testURLs(urls)

        return contentTypes
    }

    absolutizeURLs(urls: string[], baseUrl: string): string[] {

        return urls.map(url => {

            if (url.includes('://')) return url
            if (url.startsWith('../')) return baseUrl.split('/').slice(0, -2).join('/') + '/' + url.slice(3)
            if (url.startsWith('./')) return baseUrl + '/' + url.slice(2)

            return (url.startsWith('/') ? `${baseUrl.slice(1)}` : `${baseUrl}`) + '/' + url
        }) 
    }

    async testURLs(urls: string[]): Promise<String[]> {

        const contentTypes: String[] = []
    
        for (const url of urls) {
            try {
                const res = await rawFetch(url, { method: 'HEAD' })
                contentTypes.push(res.headers.get('content-type'))
            } catch (err) {}
        }

        return contentTypes
    }
}