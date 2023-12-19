import { LinksChecker } from './src/LinksChecker'
import urls from './urls.json'

const linksChecker: LinksChecker = new LinksChecker()

for (const url of urls) {
    linksChecker.checkLinksOfPage(url)
}