//Nama : M. Ali Abidillah Khotami
//NIM  : F1D02310073

//deklarasi
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

//klasifikasi grade berdasarkan nilai 
fun getGrade(nilai: Int): String {
    return when (nilai) {
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        in 0..49 -> "E"
        else -> "Nilai tidak valid"
    }
}

fun main() {

    //list data mahasiswa berisi NIM, Nama, Mata Kuliah, dan Nilai
    val mahasiswa = listOf(
        NilaiMahasiswa("  F1D0231",   "Reksa", "               Sisber              ",78),
        NilaiMahasiswa("  F1D0232",   "Rafi", "                KTI                 ",81),
        NilaiMahasiswa("  F1D0233",   "Adid", "                Pempar              ",87),
        NilaiMahasiswa("  F1D0234",   "Yoga", "                AI                  ",66),
        NilaiMahasiswa("  F1D0235",   "Aldi", "                Jarkom              ",90),
        NilaiMahasiswa("  F1D0236",   "Fia", "                 Pemweb              ",80),
        NilaiMahasiswa("  F1D0237",   "Jose", "                Probstat            ",56),
        NilaiMahasiswa("  F1D0238",   "Moluk", "               PTI                 ",65),
        NilaiMahasiswa("  F1D0239",   "Saki", "                Logif               ",72),
        NilaiMahasiswa(" F1D02310",  "Bangsin", "             Alin                ",99)
    )

    //print tabel data mahasiswa 
    println("===== DATA NILAI MAHASISWA =====\n")
    println("No    NIM          Nama                  MataKuliah            Nilai")

    //task1: menampilkan keseluruhan data mahasiswa dengan forEachIndexed
    mahasiswa.forEachIndexed { index, mhs ->
        println("${index + 1}.  ${mhs.nim}  ${mhs.nama}  ${mhs.mataKuliah}  ${mhs.nilai}")
    }

    
    //statistik nilai mahasiswa menggunakan fungsi map, average, maxByOrNull, minByOrNull
    println("\n===== STATISTIK =====")

    val rataRata = mahasiswa.map { it.nilai }.average()
    val tertinggi = mahasiswa.maxByOrNull { it.nilai }
    val terendah = mahasiswa.minByOrNull { it.nilai }
    
    //echo hasil statistik 
    println("Total Mahasiswa : ${mahasiswa.size}")
    println("Rata-rata Nilai : $rataRata")
    println("Nilai Tertinggi : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah  : ${terendah?.nilai} (${terendah?.nama})")

    
    //task2: filter mahasiswa yangyang lulus dengan nilai >= 70
    println("\n===== MAHASISWA LULUS =====")
    //filter mahasiswa yang lulus dengan nilai >= 70
    val lulus = mahasiswa.filter { it.nilai >= 70 }

    //echo hasil filter mahasiswa yang lulus dengan menampilkan nama, nilai, dan grade
    lulus.forEachIndexed { index, mhs ->
        println("${index + 1}. ${mhs.nama} - ${mhs.nilai} (${getGrade(mhs.nilai)})")
    }

   
    //task3: filter mahasiswa yang tidak lulus dengan nilai < 70
    println("\n===== MAHASISWA TIDAK LULUS =====")
    //filter mahasiswa yang tidak lulus dengan nilai < 70
    val tidakLulus = mahasiswa.filter { it.nilai < 70 }
    
    //echo hasil filter mahasiswa yang tidak lulus dengan menampilkan nama, nilai, dan grade
    tidakLulus.forEach {
        println(" ${it.nama} - ${it.nilai} (${getGrade(it.nilai)})")
    }

   
    //task7: Ascending Descending
    println("\n===== URUT NILAI ASCENDING =====")
    //urut nilai mahasiswa secara ascending menggunakan fungsi sortedBy
    val asc = mahasiswa.sortedBy { it.nilai }
    //echo hasil
    asc.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    println("\n===== URUT NILAI DESCENDING =====")
    //urut nilai mahasiswa secara descending menggunakan fungsi sortedByDescending
    val desc = mahasiswa.sortedByDescending { it.nilai }

    //echo hasil
    desc.forEach {
        println("${it.nama} - ${it.nilai}")
    }

    
    //task8: kelompok berdasarkan grade 
    println("\n===== KELOMPOK BERDASARKAN GRADE =====")
    
    //kelompokkan mahasiswa berdasarkan grade menggunakan fungsi groupBy dari fungsi getGrade
    val kelompokGrade = mahasiswa.groupBy { getGrade(it.nilai) }

    //echo hasil kelompok berdasarkan grade 
    kelompokGrade.entries.sortedBy { it.key }.forEach { (grade, list) ->
        println("Grade $grade:")
        list.forEach {
            println("${it.nama} - ${it.nilai}")
        }
    }

    //task9: jumlah mahasiswa per grade 
    println("\n===== JUMLAH PER GRADE =====")
    //jumlah mahasiswa per grade dengan menghitung ukuran list pada setiap kelompok grade
    kelompokGrade.entries.sortedBy { it.key }.forEach { (grade, list) ->
        println("Grade $grade : ${list.size} mahasiswa")
    }

    //task10: pencarian mahasiswa berdasarkan nama dengan fungsi filter dan contains
    print("\nMasukkan nama yang ingin dicari: ")
    val cari = readLine()!!.lowercase()

    //memfilter mahasiswa berdasarkan nama dengan fungsi filter dan contains untuk mencari nama
    val hasilCari = mahasiswa.filter {
        it.nama.lowercase().contains(cari)
    }
    println("\nHasil Pencarian:")
    //echo hasil pencarian mahasiswa berdasarkan nama jika tidak ditemukan maka tampilkan "Mahasiswa tidak ditemukan" jika ditemukan tampilkan nama dan nilai mahasiswa yang ditemukan
    if (hasilCari.isEmpty()) {
        println("Mahasiswa tidak ditemukan")
    } else { //jika ditemukan tampilkan nama dan nilai mahasiswa yang ditemukan
        hasilCari.forEach {
            println("${it.nama} - ${it.nilai}")
        }
    }
}