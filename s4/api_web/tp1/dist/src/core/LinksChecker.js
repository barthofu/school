import axios from 'axios';
import { getSubLinks } from '@/utils/scraper';
export class LinksChecker {
    async checkLinksOfPage(url) {
        const result = await axios.get(url);
        const html = result.data;
        getSubLinks(html);
        return 'a';
    }
}
//# sourceMappingURL=LinksChecker.js.map