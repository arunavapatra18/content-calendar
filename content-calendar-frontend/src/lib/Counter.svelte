<script lang="ts">
    import axios from 'axios';

    async function fetchData() {
        try{
            const response = await axios.get('http://localhost:8080/api/content');
            const data = response.data;
            console.log(data);
        } catch (error) {
            console.log(error);
        }
    }
</script>

<button on:click={fetchData}>
    GET ALL
</button>

