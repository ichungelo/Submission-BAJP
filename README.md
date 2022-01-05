# TEST SCHEME

## Unit test

- **MovieViewModelTest**:
    - Memuat **Movies**:
        - Memastikan data **Movies** tidak null.
        - Memastikan jumlah data **Movies** sama dengan yang diharapkan.
        - Memastikan **dataId Movies** berurutan sesuai index.
- **TvShowViewModelTest**:
    - Memuat **TvShows**:
        - Memastikan data **TvShows** tidak null.
        - Memastikan jumlah data **TvShows** sama dengan yang diharapkan.
        - Memastikan **dataId TvShows** berurutan sesuai index.
- **DetailViewModelTest**:
    - Memuat **dataId**:
        - Memastikan jika **dataId** berawalan 'm', maka akan menggunakan data **Movie**.
        - Memastikan jika **dataId** tidak berawalan 'm', maka akan menggunakan data **TvShow**.
    - Memuat **Movie** yang dipilih:
        - Memastikan data **Movie** tidak null.
        - Memastikan semua isi data **Movie** tidak null.
        - Memastikan semua isi data **Movie** sesuai dengan yang diharapkan.
    - Memuat **TvShow** yang dipilih:
        - Memastikan data **TvShow** tidak null.
        - Memastikan semua isi data **TvShow** tidak null.
        - Memastikan semua isi data **TvShow** sesuai dengan yang diharapkan.

## UI Test

- **MainActivityTest**:
    - Menampilkan data **Movies**:
        - Memastikan **rv_movies** tampil.
        - Gulir **rv_movies** ke posisi data terakhir.
    - Menampilkan data **TvShows**:
        - Memastikan **rv_tv_shows** tampil.
        - Gulir **rv_tv_shows** ke posisi data terakhir.
    - Menampilkan data detail **Movie**:
        - Gulir **rv_movies** ke posisi data terakhir.
        - Klik pada data terakhir di **rv_movies**.
        - Memastikan data **tv_detail_toolbar** sesuai dengan yang diharapkan.
        - Memastikan **img_detail_poster** tampil
        - Memastikan data **tv_detail_title** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_tagline** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_rating** sesuai dengan yang diharapkan.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Memastikan data **tv_detail_genre** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_year** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_overview** sesuai dengan yang diharapkan.
        - Klik pada button **btn_detail_back**.
        - Memastikan kembali ke activity sebelumnya dan menampilkan **rv_movies**.
    - Menampilkan data detail **TvShow**:
        - Geser kiri pada **rv_movies** sehingga menampiikan fragment TvShow.
        - Gulir **rv_tv_shows** ke posisi data terakhir.
        - Klik pada data terakhir di **rv_tv_shows**.
        - Memastikan data **tv_detail_toolbar** sesuai dengan yang diharapkan.
        - Memastikan **img_detail_poster** tampil
        - Memastikan data **tv_detail_title** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_tagline** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_rating** sesuai dengan yang diharapkan.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Memastikan data **tv_detail_genre** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_year** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_overview** sesuai dengan yang diharapkan.
        - Klik pada button **btn_detail_back**.
        - Memastikan kembali ke activity sebelumnya dan menampilkan **rv_tv_shows**.
    - Mengecek tombol **Share** pada detail **Movie**:
        - Gulir **rv_movies** ke posisi data terakhir.
        - Klik pada data terakhir di **rv_movies**.
        - Klik pada button **btn_detail_share**
    - Mengecek tombol **Share** pada detail **Movie**:
        - Geser kiri pada **rv_movies** sehingga menampiikan fragment TvShowsFragment.
        - Gulir **rv_tv_shows** ke posisi data terakhir.
        - Klik pada data terakhir di **rv_tv_shows**.
        - Klik pada button **btn_detail_share**.