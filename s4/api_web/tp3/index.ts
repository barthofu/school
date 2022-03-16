import * as prompt from 'prompt'
import axios from 'axios';

/*
Il était une fois, un petit étudiant en informatique qui devait retro-engineering un blog éphemérique... Voici les différentes étapes de son parcours :

1. Se rendre sur la page d'ajout d'article du blog
2. Ouvrir la console du navigateur
3. Se rendre dans l'onglet "Network"
4. Débuter un enregistrement (bouton rouge)
5. Remplir le formulaire de la page et appuyer sur le bouton "envoyer"
6. Une requête POST apparait alors dans la console du navigateur
7. En regardant son contenu, on remarque que :
    - Request URL: https://liris-ktbs01.insa-lyon.fr:8000/blogephem/
    - Content-Type: application/x-www-form-urlencoded
8. Et si on clique sur l'onglet "Payload", on a accès au body de la requête	qui est constitué d'un objet Form-Data avec 2 éléments :
    - title : le titre de l'article
    - body : le contenu de l'article
9. Et voilà ! On sait maintenant sur quelle URL effectuer notre requête POST, et avec quel body.


Remarques suite à la création du programme :

- Le serveur renvoie la réponse avec un status code de 201, qui correspond à "Created", indiquant qu'une ressource a bel et bien été créée

*/

async function main() {

    const { title, body }: { title: String, body: String} = await prompt.get(['title', 'body'])

    try {

        const res = await axios('https://liris-ktbs01.insa-lyon.fr:8000/blogephem/', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            data: JSON.stringify({ title, body })
        })

        console.log(`URL de l'article : ${res.data}Statut de la réponse : ${res.status}`)

    } catch (e) {
        if (e.response.status) console.error("erreur: " + e.response.data)
        else console.error(e)
    }
}

main()