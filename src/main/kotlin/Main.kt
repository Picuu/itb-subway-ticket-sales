fun main() {

    do {
        println("\n$WHITE_BACKGROUND_BRIGHT$BLACK_BOLD VENDA BITLLETS TMB $RESET")
        mostrarMenuBitllets()

        val tipusBitllet = seleccionarBitllet()
        val zones = introduirZones()
        val preuTotal = calcularPreu(tipusBitllet, zones)

        val continuar = usuariVolContinuar()
        // TODO: Si l'usuari vol continuar, permetre que compri fins a tres tiquets totals. Després mostrar preu total i etc.
        // TODO: En cas de que no volgui contiunar, mostar preu total en aquell moment i finalitzar.
        // Encara que no s'ha de finalitzar el programa com a tal, ja que la maquina (en el món real) sempre esta oberta. S'ha de finalitzar la sessió d'aquell usuari com a tal.

        // TODO: Indicar a l'usuari el preu total.
        introduirDiners(preuTotal)

        imprimirBitllets(tipusBitllet, zones)

        val volTiquet = demanarTiquet()
        if (volTiquet) {
            imprimirTiquet()
        }

    } while (usuariVolContinuar())
}

fun mostrarMenuBitllets() {
    println(PURPLE_BOLD_BRIGHT + "Menú de Bitllets:" + RESET)
    println(PURPLE + "1. Bitllet senzill")
    println("2. TCasual")
    println("3. TUsual")
    println("4. TFamiliar")
    println("5. TJove$RESET")
}

fun seleccionarBitllet(): Int {
    return readInt(BLUE + "Selecciona un tipus de bitllet: $RESET", "Introdueix un número!", "Valor fora del rang esperat!", 1, 5)
}

fun introduirZones(): Int {
    return readInt(BLUE + "Introdueix el nombre de zones (1, 2 o 3): $RESET", "Introdueix un número!", "Valor fora del rang esperat!", 1, 3)
}

fun calcularPreu(tipusBitllet: Int, zones: Int): Double {
    // Lògica per calcular el preu segons el tipus de bitllet i les zones
    // Retorna el preu calculat

    return 20.00
}

fun introduirDiners(preuTotal: Double) {
    // Lògica per a que l'usuari introdueixi els diners
    // Pots utilitzar la funció llegirDouble per llegir els diners
}

fun imprimirBitllets(tipusBitllet: Int, zones: Int) {
    // Lògica per imprimir els bitllets
    // Pots utilitzar ASCII art per millorar la presentació
}

fun demanarTiquet(): Boolean {
    return readBoolean(BLUE + "Vols un tiquet? (true/false): $RESET", "Valor introduit incorrecte!")
}

fun imprimirTiquet() {
    // Lògica per imprimir el tiquet
}

fun usuariVolContinuar(): Boolean {
    return readBoolean(BLUE + "Vols continuar comprant? (true/false): $RESET", "Valor introduit incorrecte!")
}
