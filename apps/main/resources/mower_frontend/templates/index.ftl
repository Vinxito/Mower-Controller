<html>
<head><title> SEAT:CODE - Best Mower Controller Ever</title>

    <style>
        body, input {
            font-family: Calibri, Arial;
            margin: 0px;
            padding: 0px;
        }

        #header h2 {
            color: white;
            background-color: #3275A8;
            height: 50px;
            padding: 5px 0 0 5px;
            font-size: 20px;
        }

        .datatable {
            margin-bottom: 5px;
            border: 1px solid #eee;
            border-collapse: collapse;
            width: 400px;
            max-width: 100%;
            font-family: Calibri
        }

        .datatable th {
            padding: 3px;
            border: 1px solid #888;
            height: 30px;
            background-color: #B2D487;
            text-align: center;
            vertical-align: middle;
            color: #444444
        }

        .datatable tr {
            border: 1px solid #888
        }

        .datatable tr.odd {
            background-color: #eee
        }

        .datatable td {
            padding: 2px;
            border: 1px solid #888
        }

        #content {
            padding 5px;
            margin: 5px;
            text-align: center
        }

        fieldset {
            width: 300px;
            padding: 5px;
            margin-bottom: 0px;
        }

        legend {
            font-weight: bold;
        }
    </style>

<body>
<div id="header">
    <H2>
        SEAT:CODE - Best Mower Controller Ever
    </H2>
</div>

<div id="content">

    <fieldset>

        <legend>Create Grass platerau and Mower</legend>
        <form name="control" action="save" method="post">

            X and Y Size: <input type="text" name="grassPlateau"/> <br/>

            X,Y Position and Head Facing: <input type="text" name="position"/> <br/>

            Orders: <input type="text" name="orders"/> <br/>

            <input type="submit" value="   Save   "/>
        </form>
    </fieldset>

    <br/>
    <table class="datatable">
        <#--        <tr>-->
        <#--            <th>Make</th>  <th>Model</th>-->
        <#--        </tr>-->
        <#--        <#list model["carList"] as car>-->
        <#--            <tr>-->
        <#--                <td>${car.make}</td> <td>${car.model}</td>-->
        <#--            </tr>-->
        <#--        </#list>-->

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

</div>
</body>
</html>