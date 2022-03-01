import axios from 'axios'
import { getSubLinks } from '@/utils/scraper'

export class LinksChecker {

    public async checkLinksOfPage(url: string): Promise<string> {

        const result = await axios.get(url)
        const html = result.data
        
        getSubLinks(html)

        return 'a'
    }
}