x <- c(5, 8, 11, 7, 13, 12, 12, 6)
y <- c(63, 67, 74, 64, 75, 69, 90, 60)
lm(y ~ x, data = data.frame(x = x, y = y))
residuals <- residuals(lm(y ~ x, data = data.frame(x = x, y = y)))
plot(x, residuals, main = "residuals against x")
residuals
x_new <- c(5, 8, 11, 7, 13, 12, 6)
y_new <- c(63, 67, 74, 64, 75, 69, 60)

plot(x_new, y_new, main = "estimated y against x")

abline((lm(y ~ x, data = data.frame(x = x, y = y))), col = "blue")
abline((lm(y ~ x, data = data.frame(x = x_new, y = y_new))), col = "red")
legend(11, 62,
    legend = c("with case 7", "without case 7"),
    col = c("red", "blue"), lty = 1:2, cex = 0.8
)

lm(y ~ x, data = data.frame(x = x, y = y))
lm(y ~ x, data = data.frame(x = x_new, y = y_new))

mean(x)
