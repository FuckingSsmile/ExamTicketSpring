package ru.home.examticketspring.bot.command;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.home.examticketspring.impl.TelegramServiceImpl;

import java.util.function.Consumer;

/**
 * Класс GetChatId обрабатывает полученное сообщение и отправляет идентификатор чата и пользователя.
 * Реализует интерфейс Consumer<Message>.
 */
@Service
@Log4j2
public class GetChatId implements Consumer<Message> {
    private final TelegramServiceImpl telegramService;

    public GetChatId(@Lazy TelegramServiceImpl telegramService) {
        this.telegramService = telegramService;
    }

    /**
     * Обрабатывает полученное сообщение и отправляет айди чата и пользователя.
     *
     * @param message принимает сообщение от пользователя
     */
    @Override
    public void accept(Message message) {
        String format = String.format("ID chat: %s %nUser ID: %s", message.getChatId(), message.getFrom().getId());
        telegramService.sendTextMessage(format, String.valueOf(message.getChatId()));
        log.info("Пользователь " + message.getFrom().getId() + " Выполнил команду " + this.getClass().getName());
    }
}