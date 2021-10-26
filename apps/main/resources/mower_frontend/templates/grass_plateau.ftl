<fieldset>

    <legend>Create Grass platerau</legend>
    <form name="grass_plateau" action="grass_plateau" method="post">

        X and Y Size: <input id="grass_plateau_text" type="text" name="grassPlateau"/> <br/>

        <input id="grass_plateau_button" type="submit" value="   Add   " onclick="disableGrassPlateau(); enableMower();"/>
    </form>
</fieldset>

<br/>

<script>

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
