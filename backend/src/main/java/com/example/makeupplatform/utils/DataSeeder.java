package com.example.makeupplatform.utils;

import com.example.makeupplatform.entity.*;
import com.example.makeupplatform.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final ServiceOfferRepository serviceOfferRepository;
    private final ProductRepository productRepository;
    private final PortfolioItemRepository portfolioItemRepository;
    private final ReviewRepository reviewRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .fullName("Admin Makeup")
                    .email("admin@makeup.com")
                    .password(passwordEncoder.encode("admin123"))
                    .roles(Set.of(Role.ADMIN))
                    .build();
            userRepository.save(admin);
        }
        if (serviceOfferRepository.count() == 0) {
            serviceOfferRepository.saveAll(java.util.List.of(
                    ServiceOffer.builder().name("Makeup simple").description("Maquillage naturel et élégant").durationMinutes(60).price(70.0).photoUrl("https://images.unsplash.com/photo-1522337360788-8b13dee7a37e?auto=format&fit=crop&w=900&q=80").category("Soirée").availability("Lundi-Vendredi 09:00-19:00").active(true).build(),
                    ServiceOffer.builder().name("Makeup de soirée").description("Look glamour parfait pour les événements").durationMinutes(90).price(95.0).photoUrl("https://images.unsplash.com/photo-1487412912498-0447578fcca8?auto=format&fit=crop&w=900&q=80").category("Soirée").availability("Tous les jours").active(true).build(),
                    ServiceOffer.builder().name("Makeup Mariage").description("Maquillage mariée sophistiqué").durationMinutes(120).price(180.0).photoUrl("https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?auto=format&fit=crop&w=900&q=80").category("Mariage").availability("Week-end").active(true).build()
            ));
        }
        if (productRepository.count() == 0) {
            productRepository.saveAll(java.util.List.of(
                    Product.builder().name("Fond de teint velouté").description("Teinte naturelle et longue tenue").price(45.0).salePrice(39.0).stock(12).category("Fond de teint").brand("Lumière").color("Beige").imageUrls("https://images.unsplash.com/photo-1524504388940-b1c1722653e1?auto=format&fit=crop&w=900&q=80").rating(4.8).reviewCount(24).featured(true).build(),
                    Product.builder().name("Rouge à lèvres satin").description("Couleur audacieuse et confortable").price(29.0).salePrice(24.0).stock(8).category("Rouge à lèvres").brand("Rose Studio").color("Rose").imageUrls("https://images.unsplash.com/photo-1522337360788-8b13dee7a37e?auto=format&fit=crop&w=900&q=80").rating(4.7).reviewCount(18).featured(true).build(),
                    Product.builder().name("Palette éclat").description("Palette de couleurs pour looks couture").price(68.0).salePrice(59.0).stock(5).category("Palette").brand("Éclat").color("Doré").imageUrls("https://images.unsplash.com/photo-1512496015851-a90fb38ba796?auto=format&fit=crop&w=900&q=80").rating(4.9).reviewCount(31).featured(true).build()
            ));
        }
        if (portfolioItemRepository.count() == 0) {
            portfolioItemRepository.saveAll(java.util.List.of(
                    PortfolioItem.builder().title("Soirée élégante").description("Look moderne et lumineux").eventType("Soirée").eventDate(java.time.LocalDate.of(2026, 5, 22)).imageUrl("https://images.unsplash.com/photo-1496747611176-843222e1e57c?auto=format&fit=crop&w=900&q=80").productsUsed("Fond de teint, blush").build(),
                    PortfolioItem.builder().title("Mariage romantique").description("Maquillage doux et long tenue").eventType("Mariage").eventDate(java.time.LocalDate.of(2026, 6, 3)).imageUrl("https://images.unsplash.com/photo-1524504388940-b1c1722653e1?auto=format&fit=crop&w=900&q=80").productsUsed("Palette, rouge à lèvres").build()
            ));
        }
        if (reviewRepository.count() == 0) {
            reviewRepository.saveAll(java.util.List.of(
                    Review.builder().clientName("Amélie").rating(5).comment("Service impeccable et très professionnel").imageUrl("https://images.unsplash.com/photo-1544005313-94ddf0286df2?auto=format&fit=crop&w=900&q=80").featured(true).build(),
                    Review.builder().clientName("Nadia").rating(4).comment("Résultat chic et durable toute la soirée").featured(false).build()
            ));
        }
    }
}
