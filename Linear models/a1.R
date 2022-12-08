# creating the data
x_axis <- c(1.8, 1.5, 2.0, 2.5, 1.8, 2.5, 1.6, 1.5)
y_axis <- c(51, 51, 115, 150, 126, 150, 118, 106)

# A) plotting the points on the graph
plot(x_axis, y_axis, main = "Cylinder volume and Horsepower plot", xlab = "Cylinder volume", ylab = "Horsepower", pch = 19) # nolint

# calcualting the components for b0 and b1
x_bar <- mean(x_axis)
y_bar <- mean(y_axis)
xi_xbar <- x_axis - x_bar
yi_ybar <- y_axis - y_bar
sum_num <- sum(xi_xbar * yi_ybar)
sum_den <- sum(xi_xbar**2)

# calculating b1, b1 is 65.17241
b1 <- sum_num / sum_den

print(b1)

# calculating b0, b0 is -15.45259
b0 <- y_bar - b1 * x_bar

print(b0)

# B)creating the least squares line
least_squares <- function(input) {
    return(input * b1 + b0)
}

# estimating the value using the least squares with input of 1.9L, estimation is 108.375 # nolint
print(least_squares(1.9))

# plotting the graph with the fitted line
plot(x_axis, y_axis, main = "Cylinder volume and Horsepower plot", xlab = "Cylinder volume", ylab = "Horsepower", pch = 19) # nolint
abline(a = b0, b = b1, col = "red")
