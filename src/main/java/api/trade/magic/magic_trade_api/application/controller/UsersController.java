package api.trade.magic.magic_trade_api.application.controller;

import api.trade.magic.magic_trade_api.application.controller.user.dto.CreateUserRequest;
import api.trade.magic.magic_trade_api.application.controller.user.dto.UpdateBalanceRequest;
import api.trade.magic.magic_trade_api.application.controller.user.dto.UserResponse;
import api.trade.magic.magic_trade_api.domain.model.User;
import api.trade.magic.magic_trade_api.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        User user = userService.createUser(request.getName(), request.getEmail());
        UserResponse response = toResponse(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(toResponse(user));
    }

    @PatchMapping("/{id}/balance/add")
    public ResponseEntity<UserResponse> addBalance(@PathVariable UUID id,
                                                    @Valid @RequestBody UpdateBalanceRequest request) {
        User user = userService.addBalance(id, request.getAmount());
        return ResponseEntity.ok(toResponse(user));
    }

    /**
     * Converter User (domain) para UserResponse (DTO)
     */
    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBalance(),
                user.getCreatedAt()
        );
    }
}
