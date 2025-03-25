package com.hello.neighbors.entity.enums;

public enum WithdrawalReason {

    LACK_OF_INTEREST("Manque d'intérêt"),
    PRIVACY_CONCERNS("Préoccupations concernant la confidentialité"),
    TECHNICAL_ISSUES("Problèmes techniques"),
    TOO_MANY_NOTIFICATIONS("Trop de notifications"),
    NO_RELEVANT_CONTENT("Aucun contenu pertinent"),
    FIND_BETTER_APP("Trouvé une meilleure application"),
    INACTIVE_USER("Utilisateur inactif");

    private final String description;

    WithdrawalReason(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
