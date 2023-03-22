function fillTarget(currency) {
    let target = document.getElementById('target');
    target.value = currency;
}

function fillMostPopularCurrencies() {
    let options = document.getElementById('options');
    let currencies = ['EUR', 'USD', 'CHF', 'GBP'];
    for(let i = 0; i < currencies.length; i++){
        let curr = currencies[i].toUpperCase();
        let option = `<th><button id="${curr}" class="currencyOptions" onclick="fillTarget('${curr}')">${curr}</button></th>`;
        console.log(option);
        options.innerHTML += option;
    }
}

console.log('hello');
fillMostPopularCurrencies();