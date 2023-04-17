package ru.home.examticketspring.botcommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.home.examticketspring.impl.TelegramServiceImpl;

import java.util.function.Consumer;

/**
 * Класс GetChatId обрабатывает полученное сообщение и отправляет идентификатор чата и пользователя.
 * Реализует интерфейс Consumer<Message>.
 */
@Component
public class GetChatId implements Consumer<Message> {

    @Autowired
    @Lazy
    private TelegramServiceImpl telegramService;

    /**
     * Обрабатывает полученное сообщение и отправляет идентификатор чата и пользователя.
     *
     * @param message принимает сообщение от пользователя
     */
    @Override
    public void accept(Message message) {
        String format = String.format("ID chat: %s \n User ID: %s", message.getChatId(), message.getFrom().getId());
        telegramService.sendTextMessage(format, String.valueOf(message.getChatId()));
    }
}