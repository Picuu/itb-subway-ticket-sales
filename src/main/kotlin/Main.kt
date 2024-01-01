fun main() {
    val maxBitllets:Int = 3
    var quantitat:Int = 0

    do {
        println("\n$WHITE_BACKGROUND_BRIGHT$BLACK_BOLD VENDA BITLLETS TMB $RESET")
        val bitllets:Array<String> = arrayOf("Bitllet senzill", "TCasual", "TUsual", "TFamiliar", "TJove")
        mostrarMenuBitllets(bitllets)

        val tipusBitllet = seleccionarBitllet()
        val zona = introduirZones()
        println("Ha escollit la opció: $GREEN${bitllets[tipusBitllet]}$RESET, ${GREEN}zona $zona$RESET")

        val preuTotal = calcularPreu(tipusBitllet, zona)
        println("El preu del bitllet és de $GREEN_BRIGHT$preuTotal€$RESET")

        val continuar = usuariVolContinuar()
        // TODO: Si l'usuari vol continuar, permetre que compri fins a tres tiquets totals. Després mostrar preu total i etc.
        // TODO: En cas de que no volgui contiunar, mostar preu total en aquell moment i finalitzar.
        // Encara que no s'ha de finalitzar el programa com a tal, ja que la maquina (en el món real) sempre esta oberta. S'ha de finalitzar la sessió d'aquell usuari com a tal.

        // TODO: Indicar a l'usuari el preu total.
        introduirDiners(preuTotal)

        println(imprimirBitllets(tipusBitllet, zona))

        val volTiquet = demanarTiquet()
        if (volTiquet) {
            imprimirTiquet()
        }

    } while (usuariVolContinuar())
}

fun mostrarMenuBitllets(bitllets:Array<String>) {
    println(PURPLE_BOLD_BRIGHT + "Menú de Bitllets:" + RESET)
    for (i in bitllets.indices) println("$PURPLE${i+1}. ${bitllets[i]}$RESET")
}

fun seleccionarBitllet(): Int {
    return readInt(BLUE + "Selecciona un tipus de bitllet: $RESET", "Introdueix un número!", "Valor fora del rang esperat!", 1, 5)
}

fun introduirZones(): Int {
    return readInt(BLUE + "Introdueix el nombre de zones (1, 2 o 3): $RESET", "Introdueix un número!", "Valor fora del rang esperat!", 1, 3)
}

/**
 * Aquest mètode calcula el preu del bitllet en funció de quin tipus és i les zones escollides.
 * @author AlanTeixido
 * @author Picuu
 * @since 31/12/2023
 * @param tipusBitllet Enter que representa el tipus de bitllet.
 * @param zones Enter que representa les zones que l'usuari ha escollit pel seu bitllet.
 * @return Preu final del bitllet.
 */
fun calcularPreu(tipusBitllet: Int, zones: Int): Float {
    // Lògica per calcular el preu segons el tipus de bitllet i les zones
    // Retorna el preu calculat

    val preus:Array<Float> = arrayOf(2.40f, 11.35f, 40f, 10f, 80f)
    var preu:Float = preus[tipusBitllet-1]

    if (zones == 2) preu *= 1.3125f
    else if (zones == 3) preu *= 1.8443f

    preu = String.format("%.2f", preu).toFloat()

    return preu
}

/**
 * Aquest mètode serveix per demanar a l'usuari que pagui el bitllet i mostrar-li el que falta a pagar, així com el seu canvi.
 * @author AlanTeixido
 * @author Picuu
 * @since 01/01/2024
 * @param preuTotal Preu total de tots els bitllets que es van a pagar.
 * @param quantitat Quantitat de bitllets que es van a pagar.
 * @return Canvi per al client.
 */
fun introduirDiners(preuTotal: Float, quantitat: Int = 1): Float {
    // Lògica per a que l'usuari introdueixi els diners
    // Pots utilitzar la funció llegirDouble per llegir els diners
    var canvi:Float = preuTotal

    val dinersValids:Array<Float> = arrayOf(.05f, .10f, .20f, .50f, 1f, 2f, 5f, 10f, 20f, 50f)
    println("Ha comprat $quantitat bitllets. El preu total és de  $GREEN_BRIGHT$preuTotal€")
    do {
        var dinersIntroduits:Float
        do {
            dinersIntroduits = readFloat(BLUE + "Introdueixi monedes o bitllets vàlids de EURO..." + RESET, "Introdueixi una moneda o bitllet vàlid!")
        } while (dinersIntroduits !in dinersValids)

        canvi -= dinersIntroduits
        canvi = String.format("%.2f", canvi).toFloat()
        if (canvi > 0) println("Ha introduit $dinersIntroduits€, li resta per pagar $YELLOW$canvi€$RESET")
    } while (canvi >= 0)

    println("Reculli el seu bitllet i el seu canvi: $YELLOW${-canvi}€$RESET")

    return -canvi
}

fun imprimirBitllets(tipusBitllet: Int, zones: Int): String {
    // Lògica per imprimir els bitllets
    // Pots utilitzar ASCII art per millorar la presentació

    val bitllet:String = "\n" +
            "  _______                         _      _  _  _  _          _   \n" +
            " |__   __|                       | |    (_)| |(_)| |        | |  \n" +
            "    | | ______  _ __ ___    ___  | |__   _ | | _ | |_  __ _ | |_ \n" +
            "    | ||______|| '_ ` _ \\  / _ \\ | '_ \\ | || || || __|/ _` || __|\n" +
            "    | |        | | | | | || (_) || |_) || || || || |_| (_| || |_ \n" +
            "    |_|        |_| |_| |_| \\___/ |_.__/ |_||_||_| \\__|\\__,_| \\__|\n" +
            "                                                                 \n" +
            "                                                                 "

    return bitllet
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
