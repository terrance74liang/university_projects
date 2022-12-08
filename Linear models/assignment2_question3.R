data <- read.delim("Q3.txt", sep = ",", header = FALSE)
x_axis <- c(data[1:nrow(data), 2]) # nolint
y_axis <- c(data[1:nrow(data), 1]) # nolint
anova <- aov(formula = data[, 1] ~ data[, 2], data = data)
summary(anova)

F_critical <- 5298 / 10
F_threshold <- qf(0.01, 1, nrow(data) - 2, lower.tail = FALSE)
F_threshold
F_critical <= F_threshold

least_squares <- lm(formula = data[, 1] ~ data[, 2], data = data)
least_squares
predicted_values <- predict(least_squares, as.list(x_axis))
yi_yhat <- y_axis - predicted_values
plot(x_axis, yi_yhat,
    xlim = c(0, 50), ylim = c(-30, 30), col = "black", type = "p",
    pch = 19, main = "SSE"
)

yhat_ybar <- predicted_values - mean(y_axis)
plot(x_axis, yhat_ybar,
    xlim = c(0, 50), ylim = c(-30, 30), col = "black", type = "p",
    pch = 19, main = "SSR"
)

R_square <- 5298 / (5298 + 146)
R_square

small_r <- sqrt(R_square)
small_r
