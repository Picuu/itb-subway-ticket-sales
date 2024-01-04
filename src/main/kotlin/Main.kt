/**
 * Aquest mètode s'encarrega de gestionar la venda de bitllets a TMB.
 * @author AlanTeixido
 * @author Picuu
 */
fun main() {
    val maxBitllets:Int = 3
    var quantitat:Int = 0

    while (true) {
        var continuar:Boolean = true

        println("\n$WHITE_BACKGROUND_BRIGHT$BLACK_BOLD VENDA BITLLETS TMB $RESET")
        val bitllets:Array<String> = arrayOf("Bitllet senzill", "TCasual", "TUsual", "TFamiliar", "TJove")
        val preus:FloatArray = floatArrayOf(2.40f, 11.35f, 40f, 10f, 80f)

        val bitlletsComprats:MutableList<String> = mutableListOf()
        val preusBitlletsComprats: MutableList<Float> = mutableListOf()

        while (quantitat < maxBitllets && continuar) {
            mostrarMenuBitllets(bitllets)

            val tipusBitllet = seleccionarBitllet() - 1
            val zona = introduirZones()
            println("Ha escollit la opció: $GREEN${bitllets[tipusBitllet]}$RESET, ${GREEN}zona $zona$RESET")
            quantitat++
            bitlletsComprats.add("${bitllets[tipusBitllet]} zona $zona")

            val preuBitllet = calcularPreu(preus, tipusBitllet, zona)
            println("El preu del bitllet és de $GREEN_BRIGHT$preuBitllet€$RESET")
            preusBitlletsComprats.add(preuBitllet)

            if (quantitat != 3) continuar = usuariVolContinuar()
        }

        val preuTotal:Float = preusBitlletsComprats.sum()
        val canvi: Float = introduirDiners(preuTotal, quantitat)
        println("Reculli el seu bitllet i el seu canvi: $YELLOW$canvi€$RESET")
        println(imprimirBitllets())

        if (demanarTiquet()) println(imprimirTiquet(bitlletsComprats, preusBitlletsComprats))

        println(CYAN + "Gràcies per la seva compra. Torni aviat!" + RESET)

        bitlletsComprats.clear()
        preusBitlletsComprats.clear()
        quantitat = 0
    }
}

/**
 * Mostra el menú dels bitllets disponibles.
 * @param bitllets Array dels bitllets a mostrar.
 */
fun mostrarMenuBitllets(bitllets:Array<String>) {
    println(PURPLE_BOLD_BRIGHT + "Menú de Bitllets:" + RESET)
    for (i in bitllets.indices) println("$PURPLE${i+1}. ${bitllets[i]}$RESET")
}

/**
 * Demana a l'usuari que seleccioni un tipus de bitllet.
 * @return El número del bitllet seleccionat.
 */
fun seleccionarBitllet(): Int {
    return readInt(BLUE + "Selecciona un tipus de bitllet: $RESET", "Introdueix un número!", "Valor fora del rang esperat!", 1, 5)
}
/**
 * Demana a l'usuari que introdueixi el nombre de zones.
 * @return El nombre de zones seleccionades.
 */
fun introduirZones(): Int {
    return readInt(BLUE + "Introdueix el nombre de zones (1, 2 o 3): $RESET", "Introdueix un número!", "Valor fora del rang esperat!", 1, 3)
}

/**
 * Aquest mètode calcula el preu del bitllet en funció de quin tipus és i les zones escollides.
 * @author AlanTeixido
 * @author Picuu
 * @since 31/12/2023
 * @param preus Els preus dels diferents tipus de bitllets.
 * @param tipusBitllet Enter que representa el tipus de bitllet.
 * @param zones Enter que representa les zones que l'usuari ha escollit pel seu bitllet.
 * @return Preu final del bitllet.
 */
fun calcularPreu(preus:FloatArray, tipusBitllet: Int, zones: Int): Float {
    // Lògica per calcular el preu segons el tipus de bitllet i les zones
    // Retorna el preu calculat
    var preu:Float = preus[tipusBitllet]

    if (zones == 2) preu *= 1.3125f
    else if (zones == 3) preu *= 1.8443f

    preu = roundToFloat(preu, 2)

    return preu
}

/**
 * Gestiona la introducció dels diners per al pagament dels bitllets.
 * @param preuTotal El preu total dels bitllets a pagar.
 * @param quantitat La quantitat de bitllets que es volen comprar.
 * @return El canvi per al client.
 */
fun introduirDiners(preuTotal: Float, quantitat: Int = 1): Float {
    // Lògica perquè l'usuari introdueixi els diners
    // Pots utilitzar la funció llegirDouble per llegir els diners
    var canvi:Float = preuTotal

    val dinersValids:Array<Float> = arrayOf(.05f, .10f, .20f, .50f, 1f, 2f, 5f, 10f, 20f, 50f)
    println("Ha comprat $quantitat bitllets. El preu total és de  $GREEN_BRIGHT${roundToFloat(preuTotal, 2)}€")
    do {
        var dinersIntroduits:Float
        do {
            dinersIntroduits = readFloat(BLUE + "Introdueixi monedes o bitllets vàlids de EURO..." + RESET, "Introdueixi una moneda o bitllet vàlid!")
        } while (dinersIntroduits !in dinersValids)

        canvi -= dinersIntroduits
        canvi = roundToFloat(canvi, 2)
        if (canvi > 0) println("Ha introduit $GREEN$dinersIntroduits€$RESET, li resta per pagar $YELLOW$canvi€$RESET")
    } while (canvi > 0)

    if (canvi == 0f) return canvi
    return -canvi
}

/**
 * Imprimeix una representació visual dels bitllets comprats.
 * @return Una cadena amb l'art ASCII dels bitllets.
 */
fun imprimirBitllets(): String {
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

/**
 * Demana a l'usuari si vol un tiquet de la compra.
 * @return Booleà què determina si l'usuari vol ticket o no.
 */
fun demanarTiquet(): Boolean {
    return readBoolean(BLUE + "Vols un tiquet? (true/false): $RESET", "Valor introduit incorrecte!")
}

/**
 * Imprimeix un tiquet amb la informació de la compra.
 * @param bitlletsComprats La llista amb els bitllets comprats.
 * @param preusBitlletsComprats La llista amb els preus dels bitllets comprats.
 * @return Una cadena de text amb la informació del tiquet.
 */
fun imprimirTiquet(bitlletsComprats: MutableList<String>, preusBitlletsComprats: MutableList<Float>): String {
    // Lògica per imprimir el tiquet
    val tiquetDalt:String = "------------ TIQUET TMB ------------\n"
    var tiquetInfo:String = ""
    val tiquetBaix:String = "\n------------------------------------\n"

    for (bitllet in bitlletsComprats.indices) {
        tiquetInfo += bitlletsComprats[bitllet] + " - Preu: ${preusBitlletsComprats[bitllet]}€\n"
    }

    tiquetInfo += "\n                 Preu total: ${roundToFloat(preusBitlletsComprats.sum(), 2)}€"

    val tiquet = tiquetDalt + tiquetInfo + tiquetBaix
    return tiquet
}

/**
 * Pregunta a l'usuari si vol continuar comprant.
 * @return `true` si l'usuari vol continuar, `false` altrament.
 */
fun usuariVolContinuar(): Boolean {
    return readBoolean(BLUE + "Vols continuar comprant? (true/false): $RESET", "Valor introduit incorrecte!")
}
