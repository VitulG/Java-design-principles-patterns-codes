package com.example.personal.command;


import com.example.personal.controllers.SettleUpController;
import com.example.personal.dto.SettleUpRequestDto;
import com.example.personal.enums.CommandTypes;
import org.springframework.stereotype.Component;

import java.util.List;

public class SettleUpUserCommand  implements Command {

    private final SettleUpController settleUpController;

    public SettleUpUserCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split("\\s+"));
        Long userId = Long.valueOf(words.get(0));

        SettleUpRequestDto requestDto = new SettleUpRequestDto();
        requestDto.setPayerId(userId);
        settleUpController.settleUp(requestDto);

    }

    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split("\\s+"));
        return words.size() == 2 && words.get(1).equals(CommandTypes.settleUp);
    }
}
