@RequestMapping(value = "/key", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public @ResponseBody ResponseEntity<Object> getKey(@RequestHeader("X-Auth-Token") String token) {
                
        byte[] decoded = Base64.getDecoder().decode(token);
        String username = new String();
        ByteArrayInputStream byteIn = new ByteArrayInputStream(decoded);
        try {
            ObjectInputStream ois = new ObjectInputStream(byteIn);
            Token tokenObject = (Token) ois.readObject();
            username = tokenObject.username;
 
        } catch (IOException e) {
            e.printStackTrace();
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
 
        } finally {
 
        }
 
        HashMap hm = new HashMap();
        hm.put("Key", "No Keys For User " + username);
 
        return new ResponseEntity<Object>(hm, HttpStatus.OK);
    }