const form = document.querySelector('form'),
      inputs = form.querySelectorAll('input')

let cguClicked = false

// Utils
const regex = {
    identifiant: /^[a-zA-Z]+$/,
    email: /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/,
    password: {
        specialCharacter: /[-+!*$@%_]/,
        number: /[0-9]/,
        lowerCase: /[a-z]/,
        upperCase: /[A-Z]/
    }
}

function validateForm (event) {
    event.preventDefault()    

    cguClicked = true
    const result = checkAllInputs(true)

    if (result) {
        alert('Le formulaire est valide !')
    }
}

function checkAllInputs (bypassEmptyValues = false) {

    // on utilisera l'objet formData pour récupérer les données du formulaire
    const formData = new FormData(form)
    let hasError = false

    // vérification des inputs du formulaire
    for (const [inputName, checkInputFunction] of Object.entries(checkInputs)) {

        // textes des erreurs remit à 0
        const errorSpan = document.querySelector(`#${inputName}Error`),
              inputSpan = document.querySelector(`#${inputName}`)
        errorSpan.innerHTML = ''

        // on récupère la valeur de l'input...
        let inputValue = formData.get(inputName)
        if (inputName === 'cgu' && cguClicked) inputValue = inputValue ? true : false // conversion de la valeur de la checkbox en booléen

        // ...et on la vérifie
        if (inputValue.toString().length > 0 || bypassEmptyValues === true) {
            const result = checkInputFunction(inputValue)
            if (typeof result === 'string') { // il y a une erreur
                hasError = true
                // affichage du texte de l'erreur
                errorSpan.innerHTML = result
                // affichage de l'input en rouge
                inputSpan.parentNode.classList.add('error')
            }
            else {
                // s'il n'y a pas d'erreur, on met l'input en vert
                inputSpan.parentNode.classList.remove('error')
                inputSpan.parentNode.classList.add('success')
            }
        }
    }

    return !hasError
}


const checkInputs = {

    pseudo: (pseudo) => {
        if (pseudo.length < 2 || pseudo.length > 25) return 'Le pseudo doit contenir entre 2 et 25 caractères'
        return true
    },

    age: (age) => {
        if (age < 18 || age > 100) return 'L\'âge doit être compris entre 18 et 100'
        return true
    },

    identifiant: (identifiant) => {
        if (identifiant.length > 12) return 'L\'identifiant doit contenir moins de 12 caractères'
        else if (!regex.identifiant.test(identifiant)) return 'L\'identifiant doit être composé de lettres'
        return true
    },

    email: (email) => {
        if (!regex.email.test(email)) return 'L\'email est invalide'
        return true
    },

    password: (password) => {
        
        let percent = 100,
            errorMessage = ''

        if (!regex.password.specialCharacter.test(password)) {
            percent -= 20
            errorMessage = 'Le mot de passe doit contenir au moins un caractère spécial'
        }

        if (!regex.password.number.test(password)) {
            percent -= 20
            errorMessage = 'Le mot de passe doit contenir au moins un chiffre'
        }

        if (!regex.password.lowerCase.test(password)) {
            percent -= 20
            errorMessage = 'Le mot de passe doit contenir au moins une lettre minuscule'
        }

        if (!regex.password.upperCase.test(password)) {
            percent -= 20
            errorMessage = 'Le mot de passe doit contenir au moins une lettre majuscule'
        }

        if (password.length < 8) {
            percent -= 20
            errorMessage = 'Le mot de passe doit contenir au moins 8 caractères'
        }


        if (percent < 100) return `${percent}% - ${errorMessage}`
        return true
    },

    confirmPassword: (confirmPassword) => {
        const password = document.querySelector('#password').value
        if (confirmPassword !== password || confirmPassword.length === 0) return 'Les mots de passe ne correspondent pas'
        return true
    },

    cgu: (cgu) => {
        if (!cgu) return 'Vous devez accepter les CGU'
        return true
    }
}

form.addEventListener('submit', validateForm)

for (const input of inputs) {
    input.oninput = checkAllInputs
}

form.querySelector('input[type=checkbox]').onclick = () => cguClicked = true