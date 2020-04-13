import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Bot {

    public static void main(String[] args) {




        TelegramBot bot = new TelegramBot("1175777315:AAGBN3VDb_p_Epb8l7oBWx9XfVueiGHOsSg");
        bot.setUpdatesListener(updates -> {
            System.out.println(updates.get(0).message().text());

            long chatId = updates.get(0).message().chat().id();
            SendResponse response = bot.execute(new SendMessage(chatId,updates.get(0).message().text()));


            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }
}
