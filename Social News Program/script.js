let links = []

function startPage() {
    let userInput = prompt('Choose an option:\n' +
    '1 : Show links\n' +
    '2 : Add a link\n' +
    '3 : Remove a link\n' +
    '0 : Quit');
    return userInput;
}

function addLink() {
    const title = prompt("Enter the title: ");
    const url = prompt("Enter the URL:");
    const author = prompt("Enter the author:");
    if (!url.startsWith("http://") || !url.startsWith("https://")) {
        url = "http://"+url
    }
    const link = {
        index: links.length,
        title: title,
        url: url,
        author: author
    };
    links.push(link);
}

function showLinks() {
    toAlert = "";
    for (link of links) {
        toAlert = toAlert + (`${link.index} : ${link.title} (${link.url}).Author: ${link.author}\n`);
    }
    alert(toAlert);
}

function removeALink() {
    const toRemove = prompt("Enter the index of the link to be removed:");
    if (toRemove < 0 || toRemove >= links.length) {
        alert("Invalid index");
    } else {
        links = links.filter(link => link.index != toRemove);
    }
}

function driver() {
    quit = false;
    while (!quit) {
        let selection = startPage();
        switch(selection) {
            case "1":
                showLinks();
                break;
            case "2":
                addLink();
                break;
            case "3":
                removeALink();
                break;
            case "0":
                quit = true;
                break;
            default:
                alert("Invalid selection");
        }
    }
}

driver();


