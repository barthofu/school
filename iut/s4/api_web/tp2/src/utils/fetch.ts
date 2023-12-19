import fetch from 'node-fetch'

export async function rawFetch (url: String, args: any): Promise<Response> {
    return await fetch(url, args)
}

export async function fetchHtml (url: String): Promise<String> {

    const res = await fetch(url)
    if (!res) return null

    return res.text()
}