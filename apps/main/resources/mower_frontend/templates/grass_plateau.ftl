<fieldset>

    <legend>Create Grass platerau</legend>
    <form id="form-id" name="grass_plateau" action="grass_plateau" method="post">

        X and Y Size: <input id="grass_plateau_text" type="text" name="grassPlateau"/> <br/>

        <#--        <input id="grass_plateau_button" type="submit" value="   Create   " onclick="submit(); disableGrassPlateau(); enableMower();"/>-->
        <input id="grass_plateau_button" type="submit" value="   Create   "/>

    </form>
</fieldset>

<br/>

<script>

    function checkGrassPlateau(url) {

        fetch(encodeURI(url))
            .then(function (response) {
                return response.json();
            })
            .then(function (grassPlateau) {
                if (grassPlateau) {
                    disableGrassPlateau();
                    enableMower();
                }
            });
    }

    function disableGrassPlateau() {
        document.getElementById("grass_plateau_text").disabled = true;
        document.getElementById("grass_plateau_button").disabled = true;
    }

    function enableMower() {
        document.getElementById("mower_position").disabled = false;
        document.getElementById("mower_orders").disabled = false;
        document.getElementById("mower_button").disabled = false;
    }

</script>

<script>
    checkGrassPlateau("http://localhost:8080/grass_plateau");
</script>