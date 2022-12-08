data <- read.table("Q4.txt", header = FALSE)
x_axis <- c(data[1:nrow(data), 2]) # nolint
y_axis <- c(data[1:nrow(data), 1]) # nolint

x_bar <- mean(x_axis)
y_bar <- mean(y_axis)
xi_xbar <- x_axis - x_bar
yi_ybar <- y_axis - y_bar
sum_num <- sum(xi_xbar * yi_ybar)
sum_den <- sum(xi_xbar**2)

b1 <- sum_num / sum_den

print(b1)

b0 <- y_bar - b1 * x_bar

print(b0)

least_squares <- function(input) {
    return(input * b1 + b0)
}

bounds_yh <- function(input, alpha_half, dfm) {
    MSE <- (sum((y_axis - least_squares(x_axis))^2) / (nrow(data) - 2))
    s_square <- MSE * ((1 / nrow(data)) + (((input - x_bar)^2) / sum_den))
    bounds <- c(least_squares(input) - qt(alpha_half, dfm, lower.tail = FALSE) *
        sqrt(s_square), least_squares(input) + qt(alpha_half, dfm, lower.tail = FALSE) * sqrt(s_square))
    return(bounds)
}

bounds_yh(6, 0.05, nrow(data) - 2)

bounds_yh_new <- function(input, alpha_half, dfm) {
    MSE <- (sum((y_axis - least_squares(x_axis))^2) / (nrow(data) - 2))
    s_square <- MSE * (1 + (1 / nrow(data)) + (((input - x_bar)^2) / sum_den))
    bounds <- c(least_squares(input) - qt(alpha_half, dfm, lower.tail = FALSE) *
        sqrt(s_square), least_squares(input) + qt(alpha_half, dfm, lower.tail = FALSE) *
        sqrt(s_square))
    return(bounds)
}

bounds_yh_new(6, 0.05, nrow(data) - 2)

bounds_yh_new_m <- function(input, alpha_half, dfm, m) {
    MSE <- (sum((y_axis - least_squares(x_axis))^2) / (nrow(data) - 2))
    s_square <- MSE * (1 / m + (1 / nrow(data)) + (((input - x_bar)^2) / sum_den))
    bounds <- c(least_squares(input) - qt(alpha_half, dfm, lower.tail = FALSE) * sqrt(s_square), least_squares(input) + qt(alpha_half, dfm, lower.tail = FALSE) * sqrt(s_square))
    return(bounds)
}

bounds_yh(6, 0.05, nrow(data) - 2) / 6

bounds_cbands <- function(input, alpha_half, dfm, dfm2) {
    MSE <- (sum((y_axis - least_squares(x_axis))^2) / (nrow(data) - 2))
    s_square <- MSE * ((1 / nrow(data)) + (((input - x_bar)^2) / sum_den))
    bounds <- c(least_squares(input) - sqrt(2 * qf(alpha_half, dfm, dfm2, lower.tail = FALSE))
    * sqrt(s_square), least_squares(input) + sqrt(2 * qf(alpha_half, dfm, dfm2, lower.tail = FALSE))
    * sqrt(s_square))
    return(bounds)
}

bounds_cbands(6, 0.1, 2, nrow(data))
