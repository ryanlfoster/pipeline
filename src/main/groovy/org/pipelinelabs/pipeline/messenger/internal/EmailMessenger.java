package org.pipelinelabs.pipeline.messenger.internal;

import org.pipelinelabs.pipeline.event.PipeEvent;
import org.pipelinelabs.pipeline.messenger.MessageContext;
import org.pipelinelabs.pipeline.messenger.SpecializedMessenger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailMessenger implements SpecializedMessenger {
    private final JavaMailSender sender;
    private final String from;

    public EmailMessenger(JavaMailSender sender, String from) {
        this.sender = sender;
        this.from = from;
    }

    public boolean accepts(MessageContext context) {
        return context instanceof EmailContext;
    }

    public void process(MessageContext genericContext, PipeEvent event) {
        EmailContext context = (EmailContext) genericContext;

        StringBuilder subject = new StringBuilder();
        subject.append("[pipeline] ");
        subject.append(event.getName());
        subject.append(": ");
        subject.append(event.getStatus());

        StringBuilder body = new StringBuilder();
        body.append("Pipeline Name: ");
        body.append(event.getName());
        body.append(System.getProperty("line.separator"));
        body.append("Status:        ");
        body.append(event.getStatus());
        body.append(System.getProperty("line.separator"));
        body.append("Description:   ");
        body.append(event.getDescription());
        body.append(System.getProperty("line.separator"));
        body.append("Details:");
        body.append(System.getProperty("line.separator"));
        body.append(event.getDetails());

        MimeMessage msg = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg);
        try {
            helper.setFrom(from);
            helper.setTo(context.getTo().toArray(new String[0]));
            helper.setCc(context.getCc().toArray(new String[0]));
            helper.setSubject(subject.toString());
            helper.setText(body.toString());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        sender.send(msg);
    }
}