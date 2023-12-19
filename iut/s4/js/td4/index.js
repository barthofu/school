const chapitres = []

async function fetchChapitres() {

    for (let i = 1; i <= 19; i++) {

        const res = await fetch(`./chapitres/chapitre${i}.json`)
        const json = await res.json()

        chapitres.push(json)
    }
}

function loadChapitre(chapitreNumber) {
    
        const chapitre = chapitres[chapitreNumber - 1]

        // récupération des éléments de la DOM
        const description = document.getElementById('description'),
              buttons = document.getElementById('buttons')

        // on définit la description
        description.innerHTML = chapitre.txt

        // on définit les boutons pour naviger entre les "pages"
        buttons.innerHTML = ''
        for (const link of chapitre.links) {
            const button = document.createElement('button')
            button.innerHTML = link.txt
            buttons.appendChild(button)

            button.onclick = () => loadChapitre(parseChapitreNumber(link.link))
        }
}

function parseChapitreNumber(chapitreNumber) {
    return parseInt(chapitreNumber.replace('#', ''))
}

fetchChapitres().then(_ => {
    loadChapitre(1)
})