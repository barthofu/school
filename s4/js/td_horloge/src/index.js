const horloge = new Horloge()

horloge.addAlarm(new Date(2020, 0, 1, 12, 0, 0), 'Alarme 1', 0)
horloge.update()

setInterval(() => {

    horloge.update()

    horloge.checkAlarms()
}, 1000)

document.querySelector('.add-alarm')[0].addEventListener('click', () => {
    horloge.addAlarm(new Date(), horloge.alarms.length + 1, 0)
})