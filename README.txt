Aşağıda belirttiğim senaryo PAYTR production web ortamına( https://www.paytr.com/) yazılmış bir senaryoyu içerir .Senaryo adımları sırasıyla:
1-Paytr production web sitesi açılır
2-Anasayfadaki " Ödemeler İçin İhtiyacınız Olan Her Şey ." başlığının altındaki 12 başlığın kontrolü sağlanır
3.Anasayfadaki 5 Ana başlığın kontrolü sağlanır
4.Ürünler seçeneğine giderek Online Ödeme Seçenekleri--> Linkle Ödeme Seçilir
5.Açılan ilk sayfadaki yetkili adı,soyadı,eposta,website ve işletme tipi-->Limited Şirket olarak seçilir ve KVKK onayı ile Ön başvuru yap a tıklanır(Doldurulan Alanlar excel dosyasından çekilir)
6.Açılan ikinci sayfadaki Şirket ünvanı vergi numarasi,vergi dairesi,Aylık ciro beklentiniz kısımları girilerek ön başvuru yap a tıklanır(Doldurulan Alanlar excel dosyasından çekilir)
7.Başvurunun başarılı bir şekilde alındığı görülüp başvuru numarası kaydı gerçekleştirilir.(Başarılı başvuru numarası excel de ilgili kişinin bilgilerinin bulunduğu satıra eklenmelidir.)
--Not: Önemli adımlarda site üzerinde yapılan islemlerin ekran görüntüleri alınarak screenshots klasörünün içerisine kaydedilmiştir.
Kurulum:
Java 11 veya üzeri bir JDK.
Intellij IDEA Community Edition Version : 2020.3.4

Projeyi çalıştırmadan önce gerekli bağımlılıkların yüklenmesi gerekmektedir. Bağımlılıklar:
Selenium 4.26.0---> Web otomasyonu için kullanıldı.
WebDriverManager 5.7.0-->tarayıcı sürücülerini otomatik olarak indirip yapılandırmak için kullanıldı.
Cucumber 7.20.1-->Cucumber, davranış odaklı testler yapmak için kullanıldı. Ayrıyeten Intellij Plugin'lerine Cucumber for Java'nın yüklenmesi gerekmektedir.
TestNG 7.10.2--> Testleri organize etmek ve test sonuçlarını yönetmek için kullanıldı.
Cucumber-TestNG 7.15.0--> XMl dosyası üzerinden testlerin koşulabilmesi için gerekli Cucumber-TestNG entegrasyonu için kullanıldı.
Log4j ve SLF4J--> testleri izlemek,önemli olayları konsola bastırmak ve debuglamak için loglama mekanizmaları sağlanması amacıyla  kullanıldı.
Apache POI-->Apache POI, Excel ve diğer veri işleme dosyalarını yönetmek için kullanıldı. Testlerde Excel dosyasıyla çalışıldı.
--Not:Pom.xml dosyası üzerinden gerekli bağımlılıkların kurulduğundan emin olunmalıdır.


Testlerin Çalıştırılması:
1-\Pay_TR\src\test\java\RunTests_With_Cucumber_Options klasörünün altındaki Runner klasından testi çalıştırabilirsiniz.

2-testng.xml dosyası üzerinden testleri çalıştırabilirsiniz.

3-Feature dosyası içerisinde "Scenario:" kısmının solunda yer alan Run Test seçeneği ile testi çalıştırabilirsiniz.

Test Raporlarının Görüntülenmesi:

Test bittiğinde target klasöründeki cucumber-reports.html dosyasına giderek oradaki Chrome simgesine basılarak test koşum raporunu,step detaylarını  gözlemleyebilirsiniz.
