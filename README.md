# Kumpulan Studi Kasus varBPMN

Repositori ini berisi kumpulan studi kasus terkait varBPMN. Pada setiap studi kasus, terdapat dua buah proyek yang saling berkaitan, yaitu `[nama_studi_kasus]` dan `var[nama_studi_kasus]`.

## Struktur Proyek

### 1. `var[nama_studi_kasus]`
Proyek ini menyimpan model dasar varBPMN beserta pemetaan anotasinya.
- **`src/`** (atau di dalam direktori `src/varbpmn/`): Berisi model **varBPMN** yang mendefinisikan seluruh variabilitas dari proses bisnis.
- **`feature_to_varbpmn/`**: Berisi file *mapping* anotasi variabilitas yang menghubungkan antara fitur dengan elemen yang ada pada model varBPMN.

### 2. `[nama_studi_kasus]`
Proyek ini merupakan proyek untuk menyimpan definisi fitur dan juga merupakan tempat hasil generate varian (resolusi variabilitas).
- **`model.uvl`**: Merupakan *Feature Model* yang merepresentasikan hubungan fitur dari studi kasus tersebut.
- **Config Varian**: Berisi konfigurasi dari varian-varian yang mendefinisikan fitur apa saja yang dipilih untuk di-generate.
- **`modules/`**: Folder yang berisi hasil *generated* file (model turunan) dari proses transformasi atau resolusi variabilitas varBPMN berdasarkan konfigurasi varian.
