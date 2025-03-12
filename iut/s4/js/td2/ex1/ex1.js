const body = document.body,
      toggleButton = document.querySelector('#toggleButton')


toggleButton.onclick = () => {

    // On change l'icone du bouton
    toggleButton.classList.toggle('far')
    toggleButton.classList.toggle('fas')

    // On change le background du body
    if (body.style.backgroundColor === 'white') {
        body.style.backgroundColor = 'black'
    } else {
        body.style.backgroundColor = 'white'
    }
}

// TODO(Utiliser une image)