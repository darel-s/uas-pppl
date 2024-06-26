Feature: Craft Data Form Submission

    Scenario: Successful login and form submission
        Given I am on the login page
        When I enter login username "darrielrel"
        And I enter login password "123"
        And I submit the login form
        Then I should be redirected to the user dashboard

        Given I am on the Craft Data Form page
        When the user enters "Nisa Fredlina" into the "Nama Lengkap Peserta" field
        And the user enters "fredl@email.com" into the "Email" field
        And the user enters "Universitas Gadjah Mada" into the "Asal Instansi" field
        And the user enters "081234567890" into the "Nomor Whatsapp" field
        And the user uploads "KTM_Nisa Fredlina.pdf" to the "Kartu Tanda Mahasiswa" field
        And the user uploads "Bukti Pembayaran_Nisa Fredlina.pdf" to the "Bukti Pembayaran" field
        And the user uploads "Bukti Follow PKTSL_Nisa Fredlina.pdf" to the "Bukti Follow Instagram PKTSL" field
        And the user uploads "Bukti Follow CIA_Nisa Fredlina.pdf" to the "Bukti Follow Instagram Civil In Action" field
        And the user uploads "Bukti Story CRAFT_Nisa Fredlina.pdf" to the "Bukti Story Instagram" field
        And the user clicks "Kirim Formulir"
        Then the form should be submitted successfully


