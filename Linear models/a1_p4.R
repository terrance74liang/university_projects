data <- read.delim("Data for Q4 HeightWeightData.txt")

x_axis <- c(data[1:nrow(data), 2]) # nolint
y_axis <- c(data[1:nrow(data), 3]) # nolint

# calcualting the components for b0 and b1
x_bar <- mean(x_axis)
y_bar <- mean(y_axis)
xi_xbar <- x_axis - x_bar
yi_ybar <- y_axis - y_bar
sum_num <- sum(xi_xbar * yi_ybar)
sum_den <- sum(xi_xbar**2)

# calculating b1, b1 is 1.406835
b1 <- sum_num / sum_den

print(b1)

# calculating b0, b0 is -172.8635
b0 <- y_bar - b1 * x_bar

print(b0)

# B)creating the least squares line
least_squares <- function(input) {
    return(input * b1 + b0)
}

# plotting the graph with the fitted line
plot(x_axis, y_axis, main = "height vs weight", xlab = "height", ylab = "weight", pch = 19) # nolint
abline(a = b0, b = b1, col = "red")

# calculating the mse to evaluate the fit, mse is 110.9167
mse <- sum((y_axis - unlist(lapply(x_axis, least_squares)))**2) / (nrow(data) - 2) # nolint
print(mse)
