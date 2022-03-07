const urls = [
    'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Gluehlampe_01_KMJ.png/340px-Gluehlampe_01_KMJ.png', // éteinte
    'https://kimunga.com/up/272.png' // allumée
]

const body = document.body,
      toggleButton = document.querySelector('#toggleButton'),
      bulbContainer = document.querySelector('#bulbContainer')

let state = 0

// On initialise l'image
bulbContainer.innerHTML = `<img src="${urls[state]}" alt="bulb" id="bulb" width="200px" height="200px">`

toggleButton.onclick = () => {

    // On change l'icone du bouton
    state = state === 0 ? 1 : 0

    // On change l'image
    bulbContainer.querySelector('#bulb').src = urls[state]

}