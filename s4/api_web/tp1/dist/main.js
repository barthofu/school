import urls from './configs/urls.json';
import { LinksChecker } from '@/core/LinksChecker';
const linksChecker = new LinksChecker();
for (const url of urls)
    linksChecker.checkLinksOfPage(url);
//# sourceMappingURL=main.js.map