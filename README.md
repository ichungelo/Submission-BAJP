# TEST SCHEME

## Unit test

- **TmdbRepositoryTest**:

    - Memuat **FakeTmdbRepository**:

    - Memanggil **getMovies**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan jumlah data sama dengan yang diharapkan.
        - Memastikan semua isi data yang dipanggil sama dengan yang diharapkan

    - Memanggil **getSearchMovies**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan jumlah data sama dengan yang diharapkan.
        - Memastikan semua isi data yang dipanggil sama dengan yang diharapkan

    - Memanggil **getDetailMovies**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan semua data lengkap sesuai dengan yang diharapkan.
        - Memastikan title data yang terpanggil sama dengan title data pada dummy.

    - Memanggil **getAllMoviesFavorite**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan jumlah data sama dengan yang diharapkan.
        - Memastikan semua isi data yang dipanggil sama dengan yang diharapkan

    - Memanggil **getMovieById**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan semua data lengkap sesuai dengan yang diharapkan.

    - Memanggil **getTvShows**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan jumlah data sama dengan yang diharapkan.
        - Memastikan semua isi data yang dipanggil sama dengan yang diharapkan

    - Memanggil **getSearchTvShows**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan jumlah data sama dengan yang diharapkan.
        - Memastikan semua isi data yang dipanggil sama dengan yang diharapkan

    - Memanggil **getDetailTvShow**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan semua data lengkap sesuai dengan yang diharapkan.
        - Memastikan title data yang terpanggil sama dengan title data pada dummy.

    - Memanggil **getAllTvShowsFavorite**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan jumlah data sama dengan yang diharapkan.
        - Memastikan semua isi data yang dipanggil sama dengan yang diharapkan

    - Memanggil **getTvShowById**:
        - Memastikan data yang dipanggil tidak null.
        - Memastikan semua data lengkap sesuai dengan yang diharapkan.

- **MovieViewModelTest**:

    - Memuat **Movies**:
        - Memastikan data **Movies** tidak null.
        - Memastikan setiap data pada **Movies** tidak null.
        - Memastikan setiap data pada **Movies** sama dengan yang diharapkan.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada data **Movies**

- **TvShowViewModelTest**:

    - Memuat **TvShows**:
        - Memastikan data **TvShows** tidak null.
        - Memastikan setiap data pada **TvShows** tidak null.
        - Memastikan setiap data pada **TvShows** sama dengan yang diharapkan.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada data **TvShows**

- **DetailViewModelTest**:

    - Memuat **Movie** yang dipilih:
        - Memastikan data **Movie** tidak null.
        - Memastikan semua isi data **Movie** tidak null.
        - Memastikan semua isi data **Movie** sesuai dengan yang diharapkan.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada isi data **Movie**

    - Memuat **TvShow** yang dipilih:
        - Memastikan data **TvShow** tidak null.
        - Memastikan semua isi data **TvShow** tidak null.
        - Memastikan semua isi data **TvShow** sesuai dengan yang diharapkan.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada isi data **TvShow**

- **SearchMoviesViewModelTest**:

    - Memuat **Movies**:
        - Memastikan data **Movies** tidak null.
        - Memastikan setiap data pada **Movies** tidak null.
        - Memastikan setiap data pada **Movies** sama dengan yang diharapkan.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada data **Movies**

- **SearchTvShowsViewModelTest**:

    - Memuat **TvShows**:
        - Memastikan data **TvShows** tidak null.
        - Memastikan setiap data pada **TvShows** tidak null.
        - Memastikan setiap data pada **TvShows** sama dengan yang diharapkan.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada data **TvShows**

- **FavoritMoviesViewModelTest**
    - Membuat dummy **PagedList** dengan size 10.
        - Memastikan jumlah data pada favorite sama dengan data pada dummy.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada data **PagedList**

- **FavoritTvShowsViewModelTest**
    - Membuat dummy **PagedList** dengan size 10.
        - Memastikan jumlah data pada favorite sama dengan data pada dummy.
        - Memastikan data akan selalu observe apabila terjadi perubahan pada data **PagedList**

## UI Test

- **MainActivityTest**:

    - Menampilkan data **Movies**:
        - Klik tulisan "Movies".
        - Memastikan **rv_movies** tampil.
        - Gulir **rv_movies** ke posisi data terakhir.

    - Menampilkan data **TvShows**:
        - Klik tulisan "Tv Shows".
        - Memastikan **rv_tv_shows** tampil.
        - Gulir **rv_tv_shows** ke posisi data terakhir.

    - Menampilkan data detail **Movies**:
        - Klik tulisan "Movies".
        - Klik data pertama pada **rv_movies**.
        - Memastikan data **tv_detail_toolbar** sesuai dengan yang diharapkan.
        - Memastikan **img_detail_poster** tampil.
        - Memastikan **tv_detail_title** tampil.
        - Memastikan **tv_detail_tagline** tampil.
        - Memastikan **tv_detail_rating** tampil.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Memastikan **tv_detail_backdrop** tampil.
        - Memastikan **tv_detail_genre** tampil.
        - Memastikan **tv_detail_year** tampil.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Memastikan **tv_detail_overview** tampil.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Memastikan **tv_detail_homepage** tampil.
        - Klik pada button **btn_detail_back**.
        - Memastikan kembali ke activity sebelumnya dan menampilkan **rv_movies**.

    - Menampilkan data detail **Tv Shows**:
        - Klik tulisan "Tv Shows".
        - Klik data pertama pada **rv_tv_shows**.
        - Memastikan data **tv_detail_toolbar** sesuai dengan yang diharapkan.
        - Memastikan **img_detail_poster** tampil.
        - Memastikan **tv_detail_title** tampil.
        - Memastikan **tv_detail_tagline** tampil.
        - Memastikan **tv_detail_rating** tampil.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Memastikan **tv_detail_backdrop** tampil.
        - Memastikan **tv_detail_genre** tampil.
        - Memastikan **tv_detail_year** tampil.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Memastikan **tv_detail_overview** tampil.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Memastikan **tv_detail_homepage** tampil.
        - Klik pada button **btn_detail_back**.
        - Memastikan kembali ke activity sebelumnya dan menampilkan **rv_tv_shows**.

    - Mengecek tombol **Share** pada detail **Movies**:
        - Klik tulisan "Movies".
        - Klik pada data pertama di **rv_movies**.
        - Klik pada button **btn_detail_share**.

    - Mengecek tombol **Share** pada detail **Tv Shows**:
        - Klik tulisan "Tv Show".
        - Klik pada data pertama di **rv_tv_shows**.
        - Klik pada button **btn_detail_share**.

    - Mengecek klik **Link** pada detail **Movies**:
        - Klik tulisan "Movies".
        - Klik pada data pertama di **rv_movies**.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Klik pada **tv_detail_homepage**.

    - Mengecek klik **Link** pada detail **Tv Shows**:
        - Klik tulisan "Tv Shows".
        - Klik pada data pertama di **rv_tv_shows**.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Klik pada **tv_detail_homepage**.

    - Menambah dan mengurangi data pada **Favorite Movies**:
        - Klik tulisan "Movies".
        - Klik pada data pertama di **rv_movies**.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Klik pada **btn_detail_favorite**.
        - Klik pada **btn_detail_back**.
        - Klik pada **btn_movies_favorite**.
        - Klik tulisan "Movies".
        - Klik pada data pertama di **rv_favorite_movies**.
        - Klik pada **btn_detail_favorite**.
        - Klik pada **btn_detail_back**.
        - Memastikan **img_bg_favorite_movies** tampil.

    - Menambah dan mengurangi data pada **Favorite Tv Shows**:
        - Klik tulisan "Tv Shows".
        - Klik pada data pertama di **rv_tv_shows**.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Klik pada **btn_detail_favorite**.
        - Klik pada **btn_detail_back**.
        - Klik pada **btn_tv_shows_favorite**.
        - Klik tulisan "Tv Shows".
        - Klik pada data pertama di **rv_favorite_tv_shows**.
        - Klik pada **btn_detail_favorite**.
        - Klik pada **btn_detail_back**.
        - Memastikan **img_bg_favorite_tv_shows** tampil.

    - Melakukan pencarian pada **Movies**:
        - Klik tulisan "Movies".
        - Klik pada **btn_search_movies**.
        - Ketik judul data dummy pada **sv_movies** ("Spider-Man: No Way Home"), tekan enter.
        - Klik pada data pertama di **rv_search_movies**.
        - Memastikan data **tv_detail_toolbar** sesuai dengan yang diharapkan.
        - Memastikan **img_detail_poster** tampil.
        - Memastikan data **tv_detail_title** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_tagline** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_rating** sesuai dengan yang diharapkan.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Memastikan **tv_detail_backdrop** tampil.
        - Memastikan **tv_detail_genre** tampil.
        - Memastikan **tv_detail_year** tampil.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Memastikan data **tv_detail_overview** sesuai dengan yang diharapkan.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Memastikan data **tv_detail_homepage** sesuai dengan yang diharapkan.
        - Klik pada button **btn_detail_back**.
        - Memastikan kembali ke activity sebelumnya dan menampilkan **rv_search_movies**.

    - Melakukan pencarian pada **Tv Shows**:
        - Klik tulisan "Tv Shows".
        - Klik pada **btn_search_tv_shows**.
        - Ketik judul data dummy pada **sv_tv_shows** ("Cobra Kai"), tekan enter.
        - Klik data pertama pada **rv_search_tv_shows**.
        - Memastikan data **tv_detail_toolbar** sesuai dengan yang diharapkan.
        - Memastikan **img_detail_poster** tampil.
        - Memastikan data **tv_detail_title** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_tagline** sesuai dengan yang diharapkan.
        - Memastikan data **tv_detail_rating** sesuai dengan yang diharapkan.
        - Melakukan Swipe up pada **img_detail_poster**.
        - Memastikan **tv_detail_backdrop** tampil.
        - Memastikan **tv_detail_genre** tampil.
        - Memastikan **tv_detail_year** tampil.
        - Melakukan Swipe up pada **img_detail_backdrop**.
        - Memastikan data **tv_detail_overview** sesuai dengan yang diharapkan.
        - Melakukan Swipe up pada **img_detail_overview**.
        - Memastikan data **tv_detail_homepage** sesuai dengan yang diharapkan.
        - Klik pada button **btn_detail_back**.
        - Memastikan kembali ke activity sebelumnya dan menampilkan **rv_search_tv_shows**.