import org.example.readBoolean
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    do {
        mostrarMenuBitllets()
        val tipusBitllet = seleccionarBitllet()
        val zones = introduirZones()
        val preuTotal = calcularPreu(tipusBitllet, zones)
        introduirDiners(preuTotal)
        imprimirBitllets(tipusBitllet, zones)
        val volTiquet = demanarTiquet()
        if (volTiquet) {
            imprimirTiquet()
        }

    } while (usuariVolContinuar())
}

fun mostrarMenuBitllets() {
    println("Menú de Bitllets:")
    println("1. Bitllet senzill")
    println("2. TCasual")
    println("3. TUsual")
    println("4. TFamiliar")
    println("5. TJove")
}

fun seleccionarBitllet(): Int {
    return llegirInt("Selecciona un tipus de bitllet:", 1, 5)
}

fun introduirZones(): Int {
    return llegirInt("Introdueix el nombre de zones (1, 2 o 3):", 1, 3)
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
    return readBoolean("Vols un tiquet? (true/false):", "Abduskan")
}

fun imprimirTiquet() {
    // Lògica per imprimir el tiquet
}

fun usuariVolContinuar(): Boolean {
    return readBoolean("Vols continuar comprant? (true/false):", "Abduskan")
}
