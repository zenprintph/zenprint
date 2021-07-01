package ph.com.zenprint.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ph.com.zenprint.repository.UserRepository;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final UserRepository userRepository;

    public void sendEmail(String to, String subject, String body) {

        var message = new SimpleMailMessage();
        message.setFrom("sales@autocinclus.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);
    }

    public void generateEmailConfirmation(String username) {
        var user = userRepository.getByUsername(username);

        var rnd = new Random();
        int number = rnd.nextInt(999999);

        String confirmationCode = String.format("%06d", number);

        user.setConfirmationCode(confirmationCode);

        userRepository.save(user);

        sendEmail(user.getEmail(), "Confirmation Code", confirmationCode);
    }
}
