package com.inexx.atm_project;

import com.inexx.atm_project.dto.AccountDto;
import com.inexx.atm_project.servieces.AccountServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AtmProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AccountServices accountServices) {
		return args -> {
			System.out.println("🚀 Uygulama Başlatılıyor...");

			// Test verisi oluşturalım
			AccountDto yeniHesap = new AccountDto(
					null, // ID veritabanında otomatik oluşacak
					"Muhammed İnanç",
					5000.0,
					"Maaş Hesabı",
					"TROY",
					1234
			);

			// Hesabı kaydedelim
			AccountDto olusanHesap = accountServices.hesapAc(yeniHesap);

			System.out.println("------------------------------------------------");
			System.out.println(" Örnek hesap başarıyla oluşturuldu!");
			System.out.println("👤 İsim: " + olusanHesap.name());
			System.out.println("💰 Bakiye: " + olusanHesap.balance());
			System.out.println("💳 Kart Tipi: " + olusanHesap.cardType());
			System.out.println("------------------------------------------------");
		};
	}
}
