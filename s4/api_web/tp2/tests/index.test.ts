import { LinksChecker } from '..'
import urls from '../data/urls.json'

const linksChecker = new LinksChecker()

describe('Check sublinks', () => {

    const url = urls[0]

    it('should return 4 text/html sublinks', async () => {

        expect.assertions(1)
        const contentTypes = await linksChecker.checkLinksOfPage(url)
        
        const textHtml = contentTypes.filter(ct => ct.includes('text/html'))
        expect(textHtml.length).toBe(4)
    })

    it('should return 1 image/png sublink', async () => {

        expect.assertions(1)
        const contentTypes = await linksChecker.checkLinksOfPage(url)

        const imagePng = contentTypes.filter(ct => ct.includes('image/png'))
        expect(imagePng.length).toBe(1)
    })
})