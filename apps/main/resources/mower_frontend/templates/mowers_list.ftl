
<table class="datatable">

    <thead>
    <tr>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">
            X Position
        </th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">
            Y Position
        </th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">
            Head Facing
        </th>
    </tr>
    </thead>
    <tbody id="mowers-list">

    </tbody>
</table>

<script>

    function addMowersList(url) {

        const tableBody = document.getElementById("mowers-list");

        fetch(encodeURI(url))
            .then(function (response) {
                return response.json();
            })
            .then(function (mowers) {
                tableBody.innerHTML = "";

                mowers.forEach(function (mower) {
                    let mowerRow = document.createElement("tr");

                    mowerRow.appendChild(tableCellFor(mower.xPosition));
                    mowerRow.appendChild(tableCellFor(mower.yPosition));
                    mowerRow.appendChild(tableCellFor(mower.headFacing));

                    tableBody.appendChild(mowerRow);
                })
            });
    }

    function tableCellFor(text) {
        const cell = document.createElement("td");

        cell.appendChild(document.createTextNode(text));

        return cell;
    }

</script>

<script>
    addMowersList("http://localhost:8080/mowers");
</script>