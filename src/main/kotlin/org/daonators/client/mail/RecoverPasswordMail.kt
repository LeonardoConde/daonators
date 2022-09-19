package org.daonators.client.mail

import org.daonators.wrapper.MailWrapper
import org.daonators.model.resource.User
import br.com.simpli.model.LanguageHolder

/**
 * Recover Password E-Mail handler
 * @author Simpli CLI generator
 */
class RecoverPasswordMail(lang: LanguageHolder, user: User, hash: String) : MailWrapper(lang) {
    init {
        to = "${user.email}"
        subject = lang["email_reset_password_subject"]

        data["title"] = lang["email_reset_password_title"]
        data["subtitle"] = lang["email_reset_password_subtitle"]
        data["body"] = lang["email_reset_password_body"]
        data["textButton"] = lang["email_reset_password_text_button"]
        data["labelButton"] = lang["email_reset_password_label_button"]
        data["linkButton"] = """$appUrl/#/password/reset/$hash"""

        setBodyFromTemplate(this::class.java, data, "template.html")
    }
}
