use inquire::Select;

fn main() {

    // ask for the first number
    let first_number: f64 = inquire::Text::new("Enter the first number:")
        .prompt()
        .expect("Error during input")
        .parse()
        .expect("Error converting the number");

    // ask for the operator
    let options: Vec<&str> = vec![
        "+",
        "-",
        "*",
        "/",
    ];

    let operator: &str = Select::new("Choose an operator:", options)
        .prompt() 
        .expect("Error during input");

    // ask for the second number
    let second_number: f64 = inquire::Text::new("Enter the second number:")
        .prompt()
        .expect("Error during input")
        .parse()
        .expect("Error converting the number");

    // calculate the result
    let result = match operator {
        "+" => first_number + second_number,
        "-" => first_number - second_number,
        "*" => first_number * second_number,
        "/" => first_number / second_number,
        _ => {
            println!("Unsupported operator!");
            return;
        }
    };

    // display the result
    println!("The result of {} {} {} is: {}", first_number, operator, second_number, result);
}
