// Nama: M. Ali Abidillah Khotami
// NIM: F1D02310073

fun main() {

 println("===== SISTEM PENILAIAN =====")

    //input data mahasiswa
    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()!!

    print("Masukkan Nilai UTS: ")
    val uts = readLine()!!.toInt()
    
    print("Masukkan Nilai UAS: ")
    val uas = readLine()!!.toInt()
    
    print("Masukkan Nilai Tugas: ")
    val tugas = readLine()!!.toInt()

    //menghitung nilai akhir
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)   

    //klasifikasi grade berdasarkan nilai akhir
    val grade = when (nilaiAkhir.toInt()) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }

    //keterangan berdasarkan grade
    val keterangan = when (grade) {
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    //status kelulusan berdasarkan nilai akhir
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    //echo hasil penilaian
    println("\n==== HASIL PENILAIAN ====")
    println("Nama Mahasiswa : $nama")
    println("Nilai UTS      : $uts (Bobot 30%)")
    println("Nilai UAS      : $uas (Bobot 40%)")
    println("Nilai Tugas    : $tugas (Bobot 30%)")

    println("----------------------------")
    println("Nilai Akhir    : %.1f".format(nilaiAkhir))
    println("Grade          : $grade")
    println("Keterangan     : $keterangan")
    println("Status         : $status")

    println("\nSelamat! Anda dinyatakan $status.")
}