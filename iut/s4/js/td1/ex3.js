function ex3 () {

    const age = parseInt(prompt("Quel est votre âge ?"))

    if (age >= 1 && age < 18) alert("Vous n'êtes pas encore majeur.")
    else if (age >= 18 && age < 50) alert("Vous êtes majeur mais pas encore senior.")
    else if (age >= 50 && age < 60) alert("Vous êtes senior mais pas encore retraité.")
    else if (age >= 60 && age < 121) alert("Vous êtes retraité, profitez de votre temps libre !")
    else alert("Âge invalide.")
}