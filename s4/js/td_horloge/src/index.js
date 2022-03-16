const horloge = new Horloge()

horloge.addAlarm(new Date(2020, 0, 1, 12, 0, 0), 'Alarme 1', 0)

setInterval(() => {

    horloge.update()
    horloge.checkAlarms()
})