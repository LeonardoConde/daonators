package org.daonators.client.mail

import org.daonators.wrapper.MailWrapper
import org.daonators.model.resource.AuthAdm
import br.com.simpli.model.LanguageHolder

/**
 * Recover Password E-Mail handler
 * @author Simpli CLI generator
 */
class RecoverPasswordMail(lang: LanguageHolder, authAdm: AuthAdm, hash: String) : MailWrapper(lang) {
    init {
        to = "${authAdm.email}"
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
