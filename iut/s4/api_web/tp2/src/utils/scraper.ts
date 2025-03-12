import * as cheerio from 'cheerio'

export function scrapePageForSubLinks(html): string[] {

    const $ = cheerio.load(html, { decodeEntities: false })

    const a = $('a').toArray().map(a => $(a).attr('href'))
    const img = $('img').toArray().map(img => $(img).attr('src'))

    return a.concat(img)
}